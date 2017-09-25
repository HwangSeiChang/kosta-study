package model;

public class BoardVO {
	
	private int bno;
	private String title;
	private String content;
	private String regdate;
	private String count;
	private String id;
	private String img_name;
	private String name;
	
	public BoardVO() {
		super();
	}
	
	public BoardVO(int bno, String title, String content) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
	}

	public BoardVO(String title, String content, String id, String img_name) {
		super();
		this.title = title;
		this.content = content;
		this.id = id;
		this.img_name = img_name;
	}



	public BoardVO(int bno, String title, String content, String regdate, String count, String id) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.count = count;
		this.id = id;
	}
	public BoardVO(int bno, String title, String content, String regdate, String count, String id, String img_name) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.count = count;
		this.id = id;
		this.img_name = img_name;
	}
	
	public BoardVO(int bno, String title, String content, String regdate, String count, String id, String img_name,
			String name) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.count = count;
		this.id = id;
		this.img_name = img_name;
		this.name = name;
	}

	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", regdate=" + regdate + ", count="
				+ count + ", id=" + id + ", img_name=" + img_name + ", name=" + name + "]";
	}
}
