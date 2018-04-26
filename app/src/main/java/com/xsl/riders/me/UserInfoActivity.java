package com.xsl.riders.me;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.xsl.riders.R;
import com.xsl.riders.base.BaseActivity;
import com.xsl.riders.common.Constant;
import com.xsl.riders.common.UserBean;
import com.xsl.riders.main.login.UserInfoPresenter;
import com.xsl.riders.main.login.UserInfoPresenterImp;
import com.xsl.riders.main.login.UserInfoView;
import com.xsl.riders.utils.ImageUtils;
import com.xsl.riders.utils.ProgressUtils;
import com.xsl.riders.utils.SharedPUtils;
import com.xsl.riders.utils.SnackBarUtils;
import com.xsl.riders.utils.StringUtils;
import com.xsl.riders.utils.ioc.CheckNet;
import com.xsl.riders.utils.ioc.OnClick;
import com.xsl.riders.utils.ioc.ViewById;
import com.xsl.riders.utils.ioc.ViewUtils;
import com.xsl.riders.widget.SettingItemView;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by gy on 2017/12/24.
 * 用户信息管理中心
 */
public class UserInfoActivity extends BaseActivity implements UserInfoView, SettingItemView.OnSettingItemClick {

    @ViewById(R.id.toolbar)
    Toolbar toolbar;
    @ViewById(R.id.rlt_update_icon)
    RelativeLayout iconRL;
    @ViewById(R.id.img_icon)
    ImageView iconIv;
    @ViewById(R.id.username)
    SettingItemView usernameCL;
    @ViewById(R.id.sex)
    SettingItemView sexCL;
    @ViewById(R.id.phone)
    SettingItemView phoneCL;
    @ViewById(R.id.email)
    SettingItemView emailCL;

    private UserInfoPresenter presenter;

    //选择图片来源
    private AlertDialog iconDialog;
    private AlertDialog genderDialog;
    private AlertDialog phoneDialog;
    private AlertDialog emailDialog;

    protected static final int CHOOSE_PICTURE = 0;
    protected static final int TAKE_PICTURE = 1;
    protected static final int GENDER_MAN = 0;
    protected static final int GENDER_FEMALE = 1;
    private static final int CROP_SMALL_PICTURE = 2;

    //图片路径
    protected static Uri tempUri = null;

    @Override
    protected int getLayout() {
        return R.layout.ay_user_info;
    }

    @Override
    protected void initEventAndData() {
        ViewUtils.inject(this);

        //初始化Toolbar

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.icon_back);
        toolbar.setTitle("账户信息");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回消息更新上个Activity数据
                setResult(RESULT_OK, new Intent());
                finish();
            }
        });

        if (currentUser != null) {
            //加载到布局中
            initData();
            //加载当前头像
            String imgPath = Environment.getExternalStorageDirectory().getAbsolutePath()
                    + "/" + currentUser.getImage();
            Log.i(TAG, imgPath);
            File file = new File(imgPath);
            if (file.exists()) {
                //加载图片
                Picasso.with(this).load(file).into(iconIv);

            }
        }

        presenter = new UserInfoPresenterImp(this);
        usernameCL.setOnSettingItemClick(this);
        sexCL.setOnSettingItemClick(this);
        phoneCL.setOnSettingItemClick(this);
        emailCL.setOnSettingItemClick(this);
    }

    /**
     * 将用户信息更新到布局中
     */
    private void initData() {
        usernameCL.setLeftText("用户名:               " + currentUser.getUsername());
        sexCL.setLeftText("性别:                      " + currentUser.getGender());
        phoneCL.setLeftText("电话:            " + currentUser.getPhone());
        emailCL.setLeftText("邮箱:            " + currentUser.getMail());
    }

    @Override
    public void loadDataSuccess(UserBean tData) {
        ProgressUtils.dismiss();
        SharedPUtils.setCurrentUser(mContext, currentUser);
    }

    @Override
    public void loadDataError(Throwable throwable) {
        ProgressUtils.dismiss();
        SnackBarUtils.show(mContext, "修改失败");
    }

    /**
     * 更新用户数据
     */
    @CheckNet
    public void doUpdate() {
        if (currentUser == null)
            return;

        ProgressUtils.show(UserInfoActivity.this, "正在修改...");

        presenter.update(currentUser.getId(), currentUser.getUsername(), currentUser.getGender()
                , currentUser.getPhone(), currentUser.getMail());

    }

    /**
     * 监听点击事件
     *
     * @param view
     */
    @OnClick(R.id.rlt_update_icon)
    public void onViewClicked(final View view) {
        switch (view.getId()) {
            case R.id.rlt_update_icon:  //头像
                showIconDialog();
                break;
        }
    }

    /**
     * 显示选择头像来源对话框
     */
    public void showIconDialog() {
        if (iconDialog == null) {
            iconDialog = new AlertDialog.Builder(this).setItems(new String[]{"相册", "相机"},
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case CHOOSE_PICTURE: // 选择本地照片
                                    Intent openAlbumIntent = new Intent(
                                            Intent.ACTION_GET_CONTENT);
                                    openAlbumIntent.setType("image/*");
                                    startActivityForResult(openAlbumIntent, CHOOSE_PICTURE);
                                    break;
                                case TAKE_PICTURE: // 拍照
                                    takePicture();
                                    break;
                            }
                        }
                    }).create();
        }
        if (!iconDialog.isShowing()) {
            iconDialog.show();
        }
    }

    /**
     * 显示选择性别对话框
     */
    public void showGenderDialog() {
        if (genderDialog == null) {
            genderDialog = new AlertDialog.Builder(this).setItems(new String[]{"男", "女"},
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case GENDER_MAN: // 男性
                                    if (!TextUtils.isEmpty(currentUser.getGender())) {
                                        if (currentUser.getGender().equals("F")) {
                                            currentUser.setGender("M");
                                            sexCL.setRightText(currentUser.getGender());
                                            doUpdate();
                                        }
                                    } else {
                                        currentUser.setGender("M");
                                        sexCL.setRightText(currentUser.getGender());
                                        doUpdate();
                                    }
                                    break;
                                case GENDER_FEMALE: // 女性
                                    if (!TextUtils.isEmpty(currentUser.getGender())) {
                                        if (currentUser.getGender().equals("M")) {
                                            currentUser.setGender("F");
                                            sexCL.setRightText(currentUser.getGender());
                                            doUpdate();
                                        }
                                    } else {
                                        currentUser.setGender("F");
                                        sexCL.setRightText(currentUser.getGender());
                                        doUpdate();
                                    }
                                    break;
                            }
                        }
                    }).create();
        }
        if (!genderDialog.isShowing()) {
            genderDialog.show();
        }
    }

    /**
     * 显示更换电话对话框
     */
    public void showPhoneDialog() {
        final EditText editText = new EditText(UserInfoActivity.this);
        String phone = currentUser.getPhone();
        if (phone != null) {
            editText.setText(currentUser.getPhone());
            //将光标移至文字末尾
            editText.setSelection(currentUser.getPhone().length());
        }
        if (phoneDialog == null) {
            phoneDialog = new AlertDialog.Builder(this)
                    .setTitle("电话")
                    .setView(editText)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            String input = editText.getText().toString();
                            if (input.equals("")) {
                                Toast.makeText(getApplicationContext(), "内容不能为空！" + input,
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                if (StringUtils.checkPhoneNumber(input)) {
                                    currentUser.setPhone(input);
                                    phoneCL.setRightText(input);
                                    doUpdate();
                                } else {
                                    Toast.makeText(UserInfoActivity.this,
                                            "请输入正确的电话号码", Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    })
                    .setNegativeButton("取消", null)
                    .create();
        }
        if (!phoneDialog.isShowing()) {
            phoneDialog.show();
        }
    }

    /**
     * 显示更换邮箱对话框
     */
    public void showMailDialog() {
        final EditText emailEditText = new EditText(UserInfoActivity.this);
        emailEditText.setText(currentUser.getMail());
        //将光标移至文字末尾
        emailEditText.setSelection(currentUser.getMail().length());
        if (emailDialog == null) {
            emailDialog = new AlertDialog.Builder(this)
                    .setTitle("邮箱")
                    .setView(emailEditText)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            String input = emailEditText.getText().toString();
                            if (input.equals("")) {
                                Toast.makeText(getApplicationContext(), "内容不能为空！" + input,
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                if (StringUtils.checkEmail(input)) {
                                    currentUser.setMail(input);
                                    emailCL.setRightText(input);
                                    doUpdate();
                                } else {
                                    Toast.makeText(UserInfoActivity.this,
                                            "请输入正确的邮箱格式", Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    })
                    .setNegativeButton("取消", null)
                    .create();
        }
        if (!emailDialog.isShowing()) {
            emailDialog.show();
        }
    }

    /**
     * 监听Activity返回结果
     *
     * @param requestCode
     * @param resultCode
     * @param intent
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case TAKE_PICTURE:
                    startPhotoZoom(tempUri); // 开始对图片进行裁剪处理
                    break;
                case CHOOSE_PICTURE:
                    startPhotoZoom(intent.getData()); // 开始对图片进行裁剪处理
                    break;
                case CROP_SMALL_PICTURE:
                    if (intent != null) {
                        setImageToView(intent); // 让刚才选择裁剪得到的图片显示在界面上
                    }
                    break;
            }
        }
    }

    /**
     * 监听Back键按下事件,方法2:
     * 注意:
     * 返回值表示:是否能完全处理该事件
     * 在此处返回false,所以会继续传播该事件.
     * 在具体项目中此处的返回值视情况而定.
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
            setResult(RESULT_OK, new Intent());
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 拍照
     */
    private void takePicture() {
        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (Build.VERSION.SDK_INT >= 23) {
            // 需要申请动态权限
            int check = ContextCompat.checkSelfPermission(this, permissions[0]);
            // 权限是否已经 授权 GRANTED---授权  DINIED---拒绝
            if (check != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }
        Intent openCameraIntent = new Intent(
                MediaStore.ACTION_IMAGE_CAPTURE);
        File file = new File(Environment.getExternalStorageDirectory(), "image.jpg");
        //判断是否是AndroidN以及更高的版本
        if (Build.VERSION.SDK_INT >= 24) {
            openCameraIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            tempUri = FileProvider.getUriForFile(UserInfoActivity.this,
                    "com.copasso.cocobill.fileProvider", file);
        } else {
            tempUri = Uri.fromFile(new File(Environment
                    .getExternalStorageDirectory(), "image.jpg"));
        }
        // 指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
        startActivityForResult(openCameraIntent, TAKE_PICTURE);
    }

    /**
     * 裁剪图片方法实现
     *
     * @param uri
     */
    protected void startPhotoZoom(Uri uri) {
        if (uri == null) {
            Log.i("tag", "The uri is not exist.");
        }
        tempUri = uri;
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_SMALL_PICTURE);
    }

    /**
     * 保存裁剪之后的图片数据
     *
     * @param data
     */
    protected void setImageToView(Intent data) {
        Bundle extras = data.getExtras();
        if (extras != null) {
            Bitmap photo = extras.getParcelable("data");
            photo = ImageUtils.toRoundBitmap(photo); // 这个时候的图片已经被处理成圆形的了
            iconIv.setImageBitmap(photo);
            uploadPic(photo);
        }
    }

    /**
     * 保存头像并上传服务器
     *
     * @param bitmap
     */
    private void uploadPic(Bitmap bitmap) {
        // 上传至服务器
        // 可以在这里把Bitmap转换成file，然后得到file的url，做文件上传操作
        // 注意这里得到的图片已经是圆形图片了
        // bitmap是没有做个圆形处理的，但已经被裁剪了
        String imagename = Constant.currentUserId + "_" + String.valueOf(System.currentTimeMillis());
        String imagePath = ImageUtils.savePhoto(bitmap, Environment
                .getExternalStorageDirectory().getAbsolutePath(), imagename + ".png");
        currentUser.setImage(imagename + ".png");
        SharedPUtils.setCurrentUser(UserInfoActivity.this, currentUser);
        if (imagePath != null) {
            OkHttpClient mOkHttpClient = new OkHttpClient();
            File file = new File(imagePath);
            RequestBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("file", imagename + ".png",
                            RequestBody.create(MediaType.parse("image/png"), file))
                    .build();

            Request request = new Request.Builder()
                    .header("Authorization", "Client-ID " + "...")
                    .url("http://139.199.176.173:8080/ssmBillBook/upload/")
                    .post(requestBody)
                    .build();

            mOkHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    doUpdate();
                }
            });
        }
    }

    /**
     * 权限请求
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

        } else {
            // 没有获取 到权限，从新请求，或者关闭app
            Toast.makeText(this, "需要存储权限", Toast.LENGTH_SHORT).show();
        }
    }

    @CheckNet
    @Override
    public void click(View view, boolean isChecked) {
        switch (view.getId()) {
            case R.id.username:  //用户名
                SnackBarUtils.show(mContext, "江湖人行不更名，坐不改姓！");
                break;
            case R.id.sex:  //性别
                showGenderDialog();
                break;
            case R.id.phone:  //电话修改
                showPhoneDialog();
                break;
            case R.id.email:  //邮箱修改
                showMailDialog();
                break;
            default:
                break;
        }
    }
}
