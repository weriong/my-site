package cn.luischen;

import cn.luischen.dao.BookMapper;
import cn.luischen.dao.HouseMapper;
import cn.luischen.model.Book;
import cn.luischen.model.LinkTypeData;
import cn.luischen.model.Rule;
import cn.luischen.service.ExtractService;
import cn.luischen.service.comment.CommentService;
import cn.luischen.service.log.LogService;
import cn.luischen.service.option.OptionService;
import cn.luischen.utils.ConnectionUtil;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySiteApplicationTests {

	@Test
	public void contextLoads() {
		List<Integer> integers = new ArrayList<>();
		integers.add(0);
		if (!integers.isEmpty()) {
			System.out.println("有值");
		}
	}
	@Test
	public void   test() {
		//使用时调用此方法，传入uid，如 5ef5edbdc64c1bb49e9d6899，返回的是一个字符串，可以打印出来看一下
			String uid = "2cc3c8e8ac185fcf4c2fdf8d";
//			String url="http://map.baidu.com/detail?qt=house&c=257";
			String url="http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid="+uid;
			String result = ConnectionUtil.Connect(url);
//			System.out.println(result);
//			 getHouseInfo(result,uid);

	}
	@Test
	public void jj()throws IOException {
		String url = "http://system.vdyoo.net/login.html";
		Document document = Jsoup.connect(url).timeout(3000).get();


		//通过Document的select方法获取属性结点集合
		Elements elements = document.select("a");
		//得到节点的第一个对象
		Element element = elements.get(0);
		System.out.println(element);

	}

	@Test
	public void gg() throws IOException{
		//下载网页
		String url = "https://blog.csdn.net/nav/newarticles";
		Document document = Jsoup.connect(url).timeout(3000).get();
//在下载的document里进行检索的语句
		Elements  test=document.select("#li.clearfix:nth-child(2)")
				.select("div:nth-child(1)").select("div:nth-child(1)").select("h2:nth-child(1)").select("a:nth-child(1)");
//这样test标签就是我们最开始右键单击检查的标签
		String Str=test.toString();//将标签转化成字符串
		String text=test.text();//将标签里的文本提取出来
		System.out.println(text);
//其他转换方法省略，检索到目标标签，提取标签里的特定元素so easy
	}


	@Test
	public  void  ii()throws IOException {
		//获取编辑推荐页
		Document document=Jsoup.connect("https://www.zhihu.com/explore/recommendations")
				//模拟火狐浏览器
				.userAgent("Mozilla")
				.get();
//		#zh-recommend-list-full > div > div:nth-child(14) > h2 > a
//		#zh-recommend-list-full > div > div:nth-child(1) > h2 > a
		Element main=document.getElementById("div[class=zm-item]");
		Elements url=main.select("h2").select("a[class=post-link]");
		for(Element question:url){
			//输出href后的值，即主页上每个关注问题的链接
			String URL=question.attr("abs:href");
			//下载问题链接指向的页面
			//div.zm-item:nth-child(1) > h2:nth-child(1) > a:nth-child(1)
			Document document2=Jsoup.connect(URL)
					.userAgent("Mozilla")
					.get();
			//问题div.zm-item:nth-child(5) > h2:nth-child(1) > a:nth-child(1)
			//h1.QuestionHeader-title:nth-child(2)
			Elements title = document2.select("h1[class=QuestionHeader-title]");
			//问题描述h1.QuestionHeader-title:nth-child(2)
			Elements detail=document2.select("span[class=RichText ztext]");
			//回答.QuestionRichText > div:nth-child(1) > span:nth-child(1)
			Elements answer=document2.select("#zh-question-answer-wrap")
					.select("div.zm-item-rich-text.expandable.js-collapse-body")
					.select("div.zm-editable-content.clearfix");
			System.out.println("\n"+"链接："+URL
					+"\n"+"标题："+title.text()
					+"\n"+"问题描述："+detail.text()
					+"\n"+"回答："+answer.text());
		}
	}


	@Autowired
	private HouseMapper houseMapper;//这里会报错，但是并不会影响
//	private String getHouseInfo(String targetStr,String uid) {

//		HouseInfomain houseInfomain = new HouseInfomain();
//		StringBuilder lastInfo=new StringBuilder();
//		//提取图片url
//		Pattern imgpattern=Pattern.compile("<img class=\"img-large\".*\" />");
//		Matcher imgmatcher=imgpattern.matcher(targetStr);
//		while (imgmatcher.find()){
//			String imgString=imgmatcher.group();
//			int n=imgString.lastIndexOf("=\"");
//			String imgUrl=imgString.substring(n+2,imgString.length()-3);
//System.out.println("imgRul:"+imgUrl);
//			lastInfo.append("图片url:"+imgUrl+"\n");
//			houseInfomain.setImgurl(imgUrl);
//		}
//		houseInfomain.setUid(uid);
//		//首先提取出包含房产信息的html片段，再分别处理
//		Pattern pattern1 = Pattern
//				.compile("fcg\">\\w*.+\\s*<dd>\\w*.+</dd>");
//		Matcher matcher1 = pattern1.matcher(targetStr);
//		String info = "";
//		while (matcher1.find()) {
//			info = matcher1.group();                //提取出的片段
//			Pattern pattern2 = Pattern
//					.compile("f24 fcr\">[0-9]+");
//			Matcher matcher2 = pattern2.matcher(info);
//			while (matcher2.find()) {
//
//				String price = matcher2.group().substring(9);    //提取出价格
//System.out.println("价格：" + price);
//				lastInfo.append("价格:"+price+"元/平米\n");
//				houseInfomain.setPrice(price);
//			}
//
//			Pattern pattern3 = Pattern
//					.compile("房屋类型：</dt>\\s*<dd>[\\u4e00-\\u9fa5]+( *[\\u4e00-\\u9fa5]+)*");
//			Matcher matcher3 = pattern3.matcher(info);
//			String houseType = "";            //可能有的没有
//			while (matcher3.find()) {
//				int n = matcher3.group().lastIndexOf(">");
//				houseType = matcher3.group().substring(n + 1);
//			}
//System.out.println("房屋类型：" + houseType);
//			lastInfo.append("房屋类型:"+houseType+"\n");
//			houseInfomain.setHousetype(houseType);
//			//建筑类型同理
//			Pattern pattern4 = Pattern
//					.compile("建筑类型：</dt>\\s*<dd>[\\u4e00-\\u9fa5]+( *[\\u4e00-\\u9fa5]+)*");
//			Matcher matcher4 = pattern4.matcher(info);
//			String blockType = "";            //可能有的
//			while (matcher4.find()) {
//				int n = matcher4.group().lastIndexOf(">");
//				blockType = matcher4.group().substring(n + 1);
//			}
//System.out.println("建筑类型：" + blockType);
//			lastInfo.append("建筑类型:"+blockType+"\n");
//			houseInfomain.setBlocktype(blockType);
//			//建筑年代
//			Pattern pattern5 = Pattern
//					.compile("建筑年代：</dt>\\s*<dd>[0-9]+");
//			Matcher matcher5 = pattern5.matcher(info);
//			String blockAge = "";            //可能有的没有
//			while (matcher5.find()) {
//				int n = matcher5.group().lastIndexOf(">");
//				blockAge = matcher5.group().substring(n + 1);
//			}
//System.out.println("建筑年代：" + blockAge);
//			lastInfo.append("建筑年代:"+blockAge+"\n");
//			houseInfomain.setBlockage(blockAge);
//			//容积率
//			Pattern pattern6 = Pattern
//					.compile("容积率：</dt>\\s*<dd>[0-9]+\\.[0-9]+");
//			Matcher matcher6 = pattern6.matcher(info);
//			String FAR = "";            //可能有的没有
//			while (matcher6.find()) {
//				int n = matcher6.group().lastIndexOf(">");
//				FAR = matcher6.group().substring(n + 1);
//			}
//System.out.println("容积率：" + FAR);
//			lastInfo.append("容积率:"+FAR+"\n");
//			houseInfomain.setFar(FAR);
//			//物业费
//			Pattern pattern9 = Pattern
//					.compile("物业费：</dt>\\s*<dd>[0-9]+\\.[0-9]+");
//			Matcher matcher9 = pattern9.matcher(info);
//			String fee = "";            //可能有的没有
//			while (matcher9.find()) {
//				int n = matcher9.group().lastIndexOf(">");
//				fee = matcher9.group().substring(n + 1);
//			}
//System.out.println("物业费：" + fee);
//			lastInfo.append("物业费:"+fee+"元/平米/月\n");
//			houseInfomain.setFee(fee);
//			//物业公司
//			Pattern pattern7 = Pattern
//					.compile("物业公司：</dt>\\s*<dd>[\\u4e00-\\u9fa5]+( *[\\u4e00-\\u9fa5]+)*");
//			Matcher matcher7 = pattern7.matcher(info);
//			String pManage = "";            //可能有的没有
//			while (matcher7.find()) {
//				int n = matcher7.group().lastIndexOf(">");
//				pManage = matcher7.group().substring(n + 1);
//			}
//System.out.println("物业公司：" + pManage);
//			lastInfo.append("物业公司:"+pManage+"\n");
//			houseInfomain.setPmanage(pManage);
//			//开发商
//			Pattern pattern8 = Pattern
//					.compile("开发商：</dt>\\s*<dd>[\\u4e00-\\u9fa5]+( *[\\u4e00-\\u9fa5]+)*");
//			Matcher matcher8 = pattern8.matcher(info);
//			String company = "";            //可能有的没有
//			while (matcher8.find()) {
//				int n = matcher8.group().lastIndexOf(">");
//				pManage = matcher8.group().substring(n + 1);
//			}
//System.out.println("开发商：" + pManage);
//			lastInfo.append("开发商:"+pManage+"\n");
//			houseInfomain.setPmanage(pManage);
//		}
//		HouseInfomain houseInfomain1 =houseMapper.getHouseInfoById(uid);
//		if (houseInfomain1 == null) {
//			houseMapper.insert(houseInfomain);
//		}
//		return lastInfo.toString();
//	}




	@Test
	public void test2()throws  Exception{
		//下载网页
		String URL="http://blog.csdn.net/qq_29347295?ref=toolbar";
		Document document=Jsoup.connect(URL).timeout(50000).get();
		//System.out.println(document);
		//在下载的document里进行检索的语句
		//#main > div > ul.detail > li.blog-detail > ul.blog-units.blog-units-box > li:nth-child(11) > h3 > a
//		#mainBox > main > div.article-list > div:nth-child(1) > h4 > a
		Elements test=document.select("#mainBox")
				.select("main")
				.select("div.article-list")
				.select("div:nth-child(1)")
				.select("h4")
				.select("a");
		//这样test标签就是我们最开始右键单击检查的标签
		String Str=test.toString();//将标签转化成字符串
		String text=test.text();//将标签里的文本提取出来
		System.out.println(text);
//其他转换方法省略，检索到目标标签，提取标签里的特定元素so easy

	}

	@Test
	public void test3()throws  Exception{
		//获取编辑推荐页
		Document document=Jsoup.connect("https://www.zhihu.com/explore/recommendations")
				//模拟火狐浏览器
				//.userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)")
				.userAgent("Mozilla")
				.get();
		//#zh-recommend-list-full > div > div:nth-child(1) > h2 > a
		Element main=document.getElementById("zh-recommend-list-full");
		Elements url=main.select("div").select("div:nth-child(1)")
				.select("h2").select("a[class=question_link]");
		for(Element question:url) {
			//输出href后的值，即主页上每个关注问题的链接
			String URL = question.attr("abs:href");
			//下载问题链接指向的页面
			Document document2 = Jsoup.connect(URL)
					.userAgent("Mozilla")
					.get();
			//问题#root > div > main > div > div:nth-child(11) > div.QuestionHeader > div.QuestionHeader-content > div.QuestionHeader-main > h1
			Elements title = document2.select("#root")
					.select("div")
					.select("main")
					.select("div")
					.select("div:nth-child(11)")
					.select("div.QuestionHeader")
					.select("div.QuestionHeader-content")
					.select("div.QuestionHeader-main")
					.select("h1");
			//问题描述#root > div > main > div > div:nth-child(11) > div.QuestionHeader > div.QuestionHeader-content > div.QuestionHeader-main > div:nth-child(3) > div > div > div > span
			Elements detail = document2.select("#root")
					.select("div")
					.select("main")
					.select("div")
					.select("div:nth-child(11)")
					.select("div.QuestionHeader")
					.select("div.QuestionHeader-content")
					.select("div.QuestionHeader-main")
					.select("div:nth-child(3)")
					.select("div")
					.select("div")
					.select("div")
					.select("span");
			//回答--#root > div > main > div > div.Question-main > div.Question-mainColumn > div.Card.AnswerCard > div > div > div.RichContent.RichContent--unescapable > div.RichContent-inner > span > p:nth-child(1)
			Elements answer = document2.select("#root")
					.select("div")
					.select("main")
					.select("div")
					.select("div.Question-main")
					.select("div.Question-mainColumn")
					.select("div.Card.AnswerCard")
					.select("div")
					.select("div")
					.select("div.RichContent.RichContent--unescapable")
					.select("div.RichContent-inner")
					.select("span");
			//.select("p:nth-child(1)");
			System.out.println("\n" + "链接：" + URL
					+ "\n" + "标题：" + title.text()
					+ "\n" + "问题描述：" + detail.text()
					+ "\n" + "回答：" + answer.text());
		}
	}


	@Test
	public void StringSize() {
		String i = "http://webmap2.map.bdimg.com/maps/services/thumbnails?width=350&height=200&align=center,center&src=http://pcsv0.map.bdimg.com/%3Fqt%3Dpr3d%26fovy%3D65%26quality%3D100%26panoid%3D02000200001407031058073700B%26heading%3D212%26pitch%3D-10.439999580383%26width%3D800%26height%3D600";
		System.out.println(i.length());
	}

	/**
	 * 测试百度新闻
	 */
	@Test
	public void iei() {
			Rule rule = new Rule("http://news.baidu.com/ns",
					new String[] { "word" }, new String[] { "符伟荣" },
					null, -1, Rule.GET);
			List<LinkTypeData> extracts = ExtractService.extract(rule);
			System.out.println(extracts);
	}
	@Test
	public void iia() {
		Rule rule = new Rule("http://www.baidu.com/s",
				new String[] { "wd" }, new String[] { "魔力宝贝" },
				null, -1, Rule.GET);
		List<LinkTypeData> extracts = ExtractService.extract(rule);

		List<LinkTypeData> results=new ArrayList<LinkTypeData>();
		for (LinkTypeData list : extracts) {
			if (list.getLinkText().isEmpty()) continue;
			if (list.getLinkText().indexOf("魔力宝贝")!=-1) {
				results.add(list);
			}
		}
		System.out.println(results);
	}


	@Test
	public void tete() {
		List<String> names=new ArrayList<>();
		names.add("wangyi");    //索引为0
		names.add("huagnshuaoi");    //索引为1
		names.add("张飞");    //索引为2
		names.add("刘备");    //索引为3
		names.add("张飞");    //索引为4
		System.out.println(names.indexOf("huagnshuaoi"));
	}

	@Autowired
	OptionService optionService;
	@Autowired
	CommentService commentService;
	@Autowired
	LogService logService;
	@Test
	public void tete2() {

		logService.deleteLogById(83);

	}

	/**
	 * 主要是记笔记
	 */
	@Test
	public  void note() {
		//微服务，相当于一个电影售票系统为例， 1.电影微服务，2.用户微服务，3订单微服务
		//Spring Cloud：在Spring boot基础上构建，用于快速构建分布式系统的通用模式的工具集
		//服务提供者：服务的被调用方
		//服务消费者：服务的调用方
		long begintime = System.currentTimeMillis();
		for (int i=0;i<=100;i++) {
			System.out.println("王炸");
		}
		long endtime = System.currentTimeMillis();
		System.out.println("使用的时间是" + (endtime - begintime));
	}


	@Autowired
	BookMapper bookMapper;
	@Test
	public void  pachong() {
	  final  String SEARCH_URL = "https://search.jd.com/Search?keyword=";
			try {
				Connection.Response response = Jsoup.connect(SEARCH_URL+"iphone xs max 256G").method(Connection.Method.GET).execute();//连接网络请求
				if (response.statusCode()==200)
				{
					Document document = Jsoup.parse(response.body());
					Elements elements = document.select("ul[class=gl-warp clearfix]").select("li[class=gl-item]");
					if (elements!=null&&elements.size()>0)
					{
						int i = 0;
						for (Element e:elements)
						{
							if (i == 0) {
								System.out.println("bookId"+e.attr("data-sku"));
//							System.out.println("price"+e.select("div[class=p-price]").select("strong").select("i").text());
//							System.out.println("titile"+e.select("div[class=p-name]").select("em").text());
//							System.out.println("comment"+e.select("div[class=p-commit]").select("strong").select("a").text());
								System.out.println(e.attr("src"));
								System.out.println(e.select("div[class=p-shop]").select("span[class=J_im_icon]").select("a").attr("title"));
								Book bookcha=bookMapper.getBookById(e.attr("data-sku"));
								if (bookcha == null) {
									Book book = new Book();
									book.setId(e.attr("data-sku"));
									book.setPrice(Double.parseDouble(e.select("div[class=p-price]").select("strong").select("i").text()));
									book.setTitle(e.select("div[class=p-name p-name-type-2]").select("a").select("em").text());
									book.setSrc(e.select("div[class=p-img]").select("a").select("img").attr("src"));
									book.setStore(e.select("div[class=p-shop]").select("span[class=J_im_icon]").select("a").attr("title"));
									book.setComment(e.select("div[class=p-commit]").select("strong").select("a").text());
									bookMapper.insert(book);
									i++;
								}
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	@Test
	public void  jj1() {
		List<Book> books = bookMapper.findBookByLikeTitle("");
		for (Book book : books) {
			System.out.println("title:"+book.getTitle()+"，"+"price:"+book.getPrice()+"，"+"comment:"+book.getComment());
		}
		Map<String,Object> map = new HashMap<>();
		map.entrySet().size();

	}

	@Test
	public void jo() {
			char data[] = {'a', 'b', 'c'};
			String str = new String(data);
			System.out.println(str);
			String cde = "cde";
			System.out.println("abc" + cde);
			String c = "abc".substring(2,3);
			String d = cde.substring(1, 2);
	}

	@Test
	public  void shshMapTest() {
		System.out.println();
	}



}

