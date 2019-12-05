package com.prc.test.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SqlSessionFactory ssf;

	public List<UserVO> selectUserList(UserVO param) {
		SqlSession ss = ssf.openSession();
		try {
			return ss.selectList("com.bdi.prc.dao.UserInfoMapper.selectUserInfo", param);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss.commit();
			ss.close();

		}
		return null;
	}

	public List<UserVO> selectUserVOList(UserVO param) {
		SqlSession ss = ssf.openSession();
		try {
			return ss.selectList("com.bdi.prc.dao.UserInfoMapper.selectUserInfoList", param);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss.commit();
			ss.close();

		}
		return null;
	}

	public int insertUserInfo(UserVO user) {
		SqlSession ss = ssf.openSession();
		try {
			return ss.insert("com.bdi.prc.dao.UserInfoMapper.insertUserInfo", user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss.commit();
			ss.close();

		}
		return 0;
	}

	public int updateUserInfo(UserVO user) {
		SqlSession ss = ssf.openSession();
		try {
			return ss.update("com.bdi.prc.dao.UserInfoMapper.updateUserInfo", user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss.commit();
			ss.close();

		}
		return 0;
	}

	@Override
	public int deleteUserInfo(UserVO user) {
		SqlSession ss = ssf.openSession();
		try {
			return ss.delete("com.bdi.prc.dao.UserInfoMapper.deleteUserInfo", user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss.commit();
			ss.close();

		}
		return 0;
	}

	@Override
	public UserVO selectUserInfo(UserVO user) {
		SqlSession ss = ssf.openSession();
		try {
			return ss.selectOne("com.bdi.prc.dao.UserInfoMapper.loginUserInfo", user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			ss.close();

		}
		return null;
	}
}
