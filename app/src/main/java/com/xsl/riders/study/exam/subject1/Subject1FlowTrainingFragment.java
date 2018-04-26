package com.xsl.riders.study.exam.subject1;

import com.xsl.riders.study.controllers.exam.TrainingFragment;
import com.xsl.riders.study.controllers.exam.TrainingType;
import com.xsl.riders.study.reader.Question;
import com.xsl.riders.study.reader.QuestionsReadUtil;

import java.util.List;

/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2018/2/21,Time:10:23
 * Description:
 */

public class Subject1FlowTrainingFragment extends TrainingFragment {
    @Override
    protected String getQuestionsBaseDir() {
        return QuestionsReadUtil.SUBJECT1_PATH;
    }

    @Override
    protected TrainingType getTrainingType() {
        return TrainingType.FLOW;
    }

    @Override
    public List<Question> getSourceQuestions() {
        return QuestionsReadUtil.readSubject1(Subject1FlowTrainingFragment.this.getContext());
    }
}
