package com.mycompany.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.NoticeDao;
import com.mycompany.webapp.dto.Notice;
import com.mycompany.webapp.dto.Pager;

@Service
public class NoticeService {
	@Autowired
	NoticeDao noticeDao;

	public void write(Notice notice) {
		int reviewCnt = noticeDao.insert(notice);

	}

	public int getCount() {
		return noticeDao.countAll();
	}

	public List<Notice> getList(Pager pager) {
		return noticeDao.selectByPage(pager);
	}

	public Notice readNotice(int nno) {
		Notice notice = noticeDao.selectNoticeByNno(nno);
		return notice;
	}

}
