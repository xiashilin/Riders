package com.xsl.riders.study.exam.subject1;

import com.xsl.riders.study.controllers.exam.MockExamFragment;
import com.xsl.riders.study.controllers.exam.Subject;
import com.xsl.riders.study.reader.Question;
import com.xsl.riders.study.reader.QuestionsReadUtil;

import java.util.List;

/**
 * Created by plter on 7/5/17.
 */

public class Subject1MockExamFragment extends MockExamFragment {


    public Subject1MockExamFragment() {
        getPageTitle().set("科目一模拟考试");
    }

    @Override
    protected List<Question> getSourceQuestions() {
        return QuestionsReadUtil.readSubject1(getContext());
    }

    @Override
    protected Subject getSubject() {
        return Subject.Subject1;
    }
}
