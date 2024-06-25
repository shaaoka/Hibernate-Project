package com.team6.model;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class MemberDao implements MemberDaoInterface {

	private Session session;

	public MemberDao(Session session) {
		this.session = session;
	}

	@Override
	public BossAccount login(String account, String pwd) {
		String hql = "from BossAccount where account= :a and password = :p";
		try {
			Query<BossAccount> query = session.createQuery(hql, BossAccount.class).setParameter("a", account)
					.setParameter("p", pwd);
			BossAccount boss = query.getSingleResult();

			return boss;

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public MemberBean insert(MemberBean bean) {
		MemberBean memberBean = session.get(MemberBean.class, bean.getAccount());
		if (memberBean == null) {
			session.save(bean);
			return bean;
		}
		return null;

	}

	@Override
	public boolean delete(String account) {
		MemberBean bean = session.get(MemberBean.class, account);
		if (bean != null) {
			session.delete(bean);
			return true;
		}
		return false;
	}

	@Override
	public MemberBean upDate(MemberBean bean) {
		MemberBean memberBean = session.get(MemberBean.class, bean.getAccount());
		System.out.println(memberBean);
		if (memberBean != null) {
			memberBean.setmName(bean.getmName());
			memberBean.setPassword(bean.getPassword());
			memberBean.setmEmail(bean.getmEmail());
			memberBean.setmPhone(bean.getmPhone());
			memberBean.setBirthday(bean.getBirthday());
			memberBean.setPermissions(bean.getPermissions());
			return memberBean;
		}
		return null;
	}

	@Override
	public boolean upDataByPermissions(String account, String permissions) {
		MemberBean bean = session.get(MemberBean.class, account);
		if (bean != null) {
			bean.setPermissions(Integer.parseInt(permissions));
			return true;
		}
		return false;
	}

	@Override
	public MemberBean selectByOne(String account) {
		return session.get(MemberBean.class, account);
	}

	@Override
	public List<MemberBean> selectByName(String name) {
		String hql = "from MemberBean where mName like :name";
		try {
			Query<MemberBean> query = session.createQuery(hql, MemberBean.class).setParameter("name", "%" + name + "%");
			List<MemberBean> beans = query.getResultList();
			return beans;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<MemberBean> selectAll() {
		try {
			Query<MemberBean> query = session.createQuery("from MemberBean", MemberBean.class);
			List<MemberBean> beans = query.getResultList();
			return beans;

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean saveToCsv() {
		String file = "C:\\Users\\User\\Downloads\\newMember.csv";
		String csv = "account,mName,password,mEmail,mPhone,birthday,permissions\n";
		Query<MemberBean> query = session.createQuery("from MemberBean", MemberBean.class);
		List<MemberBean> beans = query.getResultList();
		try (FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos);) {
			for (MemberBean bean : beans) {
				csv += bean.saveToCsv()+"\n";
			}
			byte[] bytes = csv.getBytes();
			bos.write(bytes);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean saveToXml() {
		String file = "C:\\Users\\User\\Downloads\\newMember.xml";
		String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\n"+"<Root>"+"\n";
		Query<MemberBean> query = session.createQuery("from MemberBean", MemberBean.class);
		List<MemberBean> beans = query.getResultList();
		try (FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos);) {
			for (MemberBean bean : beans) {
				xml += bean.saveToXml();
			}
			xml +="</Root>";
			byte[] bytes = xml.getBytes();
			bos.write(bytes);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean saveToJson() {
		String file = "C:\\Users\\User\\Downloads\\newMember.json";
		String json= "[";
		Query<MemberBean> query = session.createQuery("from MemberBean", MemberBean.class);
		List<MemberBean> beans = query.getResultList();
		try (FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos);) {
			for (MemberBean bean : beans) {
				json += bean.saveToJson()+"\n";
			}
			json=json.substring(0, json.length()-2)+"\n]";
			byte[] bytes = json.getBytes();
			bos.write(bytes);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
