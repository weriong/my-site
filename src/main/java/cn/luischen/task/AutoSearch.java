package cn.luischen.task;

import cn.luischen.common.Task;
import org.springframework.stereotype.Service;

/**
 * 描述：
 * Author: 符伟荣 【wr.fu@vdyoo.com】
 * Date: 2018/8/30
 */
@Service
public class AutoSearch implements Task {
    @Override
    public void run() {
        //获取编辑推荐页
//        Document document= Jsoup.connect("https://www.zhihu.com/explore/recommendations")
//                //模拟火狐浏览器
//                .userAgent("Mozilla")
//                .get();
////		#zh-recommend-list-full > div > div:nth-child(14) > h2 > a
////		#zh-recommend-list-full > div > div:nth-child(1) > h2 > a
//        Element main=document.getElementById("div[class=zm-item]");
//        Elements url=main.select("h2").select("a[class=post-link]");
//        for(Element question:url){
//            //输出href后的值，即主页上每个关注问题的链接
//            String URL=question.attr("abs:href");
//            //下载问题链接指向的页面
//            //div.zm-item:nth-child(1) > h2:nth-child(1) > a:nth-child(1)
//            Document document2=Jsoup.connect(URL)
//                    .userAgent("Mozilla")
//                    .get();
//            //问题div.zm-item:nth-child(5) > h2:nth-child(1) > a:nth-child(1)
//            //h1.QuestionHeader-title:nth-child(2)
//            Elements title = document2.select("h1[class=QuestionHeader-title]");
//            //问题描述h1.QuestionHeader-title:nth-child(2)
//            Elements detail=document2.select("span[class=RichText ztext]");
//            //回答.QuestionRichText > div:nth-child(1) > span:nth-child(1)
//            Elements answer=document2.select("#zh-question-answer-wrap")
//                    .select("div.zm-item-rich-text.expandable.js-collapse-body")
//                    .select("div.zm-editable-content.clearfix");
//            System.out.println("\n"+"链接："+URL
//                    +"\n"+"标题："+title.text()
//                    +"\n"+"问题描述："+detail.text()
//                    +"\n"+"回答："+answer.text());
//        }

        while (true) {
            //为了计算运行一次需要多少时间
            System.out.println("一直循环的跑");
        }
    }

}
