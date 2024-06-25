package com.team6.model;

import java.util.List;

public interface MemberDaoInterface {

	// 登入
	BossAccount login(String account, String pwd);
	
	// 新增一筆
	MemberBean insert(MemberBean bean);
	
	// 刪除一筆
	boolean delete(String account);
	
	// 更新一筆
	MemberBean upDate(MemberBean bean);
	
	// 更新權限
	boolean upDataByPermissions(String account, String permissions);
	
	// 查詢單筆
	MemberBean selectByOne(String account);
	
	// 模糊查詢(名字)
	List<MemberBean> selectByName(String name);
	
	// 查詢全部
	List<MemberBean> selectAll();
	
	// 下載檔案
	boolean saveToCsv();
	boolean saveToXml();
	boolean saveToJson();
}
