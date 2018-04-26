package com.xsl.riders.study.exam.subject4;

import com.xsl.riders.study.controllers.exam.MockExamFragment;
import com.xsl.riders.study.controllers.exam.Subject;
import com.xsl.riders.study.reader.Question;
import com.xsl.riders.study.reader.QuestionsReadUtil;

import java.util.List;

/**
 * Created by plter on 7/5/17.
 */

public class Subject4MockExamFragment extends MockExamFragment {


    @Override
    protected List<Question> getSourceQuestions() {
        return QuestionsReadUtil.readSubject4(getContext());
    }

    @Override
    protected Subject getSubject() {
        return Subject.Subject4;
    }
}
