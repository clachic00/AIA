package guestbook.model;

import java.util.List;

public class MessageListView {

	// 전체 게시물의 개수

	private int messageTotalCount;

	// 현재페이지 번호

	private int currentPageNumber;

	// 전체 페이지의 번호

	private int pageTotalCount;

	// 메세지 리스트

	private List<Message> messageList;

	// 페이지 당 표현 게시물의 개수
	private int messageCountPerpage;

	// 게시물의 시작 행

	private int startRow;

	// 게시물의 마지막 행

	private int endRow;

	public MessageListView(int messageTotalCount, int currentPageNumber, List<Message> messageList,
			int messageCountPerpage, int startRow, int endRow) {
		super();
		this.messageTotalCount = messageTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.messageList = messageList;
		this.messageCountPerpage = messageCountPerpage;
		this.startRow = startRow;
		this.endRow = endRow;
		calTotalPageCount();

	}

	// new MessageListView();

	private void calTotalPageCount() {

		if (messageTotalCount == 0) {
			pageTotalCount = 0;
		} else {
			pageTotalCount = messageTotalCount / messageCountPerpage;
			if (messageTotalCount % messageCountPerpage > 0) {
				pageTotalCount++;
			}
		}
	}

	public int getMessageTotalCount() {
		return messageTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public int getMessageCountPerpage() {
		return messageCountPerpage;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	@Override
	public String toString() {
		return "MessageListView [messageTotalCount=" + messageTotalCount + ", currentPageNumber=" + currentPageNumber
				+ ", pageTotalCount=" + pageTotalCount + ", messageList=" + messageList + ", messageCountPerpage="
				+ messageCountPerpage + ", startRow=" + startRow + ", endRow=" + endRow + "]";
	}

	public boolean isEmpty() {
		return messageTotalCount == 0;
	}

}
