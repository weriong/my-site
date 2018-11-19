package cn.luischen;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * Author: 符伟荣 【wr.fu@vdyoo.com】
 * Date: 2018/8/30
 */
@Service
public class AllTaskCommandLineRunner implements CommandLineRunner {
    public AllTaskCommandLineRunner() {
    }
    private List<Runnable> tasks=new ArrayList<>();
    void registTask(){
//        tasks.add(stateCountTack);
//        tasks.add(stateStudentCountExamTask);
//        tasks.add(answerStateCountTack);
//        tasks.add(vidyoUserSyncTask);
//        tasks.add(refreshMpushUserStatusTask);
//        tasks.add(tenMinutesEndTask);
//        tasks.add(refreshVPollUserStatusTask);
//        tasks.add(refreshAnswerInfoTask);
//        tasks.add(studentUsedTimeTack);
//        tasks.add(autoSwithVideoTask);
    }
    @Override
    public void run(String... strings) throws Exception {
        registTask();
        for (Runnable runnable : tasks) {
            Thread thread=new Thread(runnable);
            thread.start();
        }
    }
}
