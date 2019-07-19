package com.cy.pj.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.dao.TrainDao;
import com.cy.pj.pojo.Train;
import com.cy.pj.service.TrainService;
@Service
public class TrainServiceImpl implements TrainService{
	@Autowired
	private TrainDao dao;

	/**
	 * 查询所有培训记录业务处理
	 * @return
	 */
	@Override
	public List<Train> findObjects() {
		List<Train> list = dao.findObjects();
		//判断查询的培训信息是否为空,或者为0
		if(list.size()==0||list.isEmpty())
			throw new RuntimeException("暂时还没有培训记录");
		return list;
	}
	/**
	 * 添加一条培训记录
	 * @param train 封装添加的培训信息
	 * @return 改变的行数
	 */
	@Override
	public int addTrainObject(Train train) {
		//判断非空
		if(train.getTnMan()==null||train.getTnMan()=="")
			throw new RuntimeException("培训人不能为空");
		if(train.getTnJoin()==null||train.getTnJoin()=="")
			throw new RuntimeException("参加人员不能为空");
		if(train.getTnTitle()==null||train.getTnTitle()=="")
			throw new RuntimeException("培训主题不能为空");
		if(train.getTnAddress()==null||train.getTnAddress()=="")
			throw new RuntimeException("培训地点不能为空");
		if(train.getTnTime()==null||train.getTnTime()=="")
			throw new RuntimeException("培训时间不能为空");
		if(train.getTnContent()==null||train.getTnContent()=="")
			throw new RuntimeException("培训宗旨不能为空");
		int rows = dao.addTrainObject(train);
		if (rows == 0)
			throw new RuntimeException("插入失败!");
		return rows;
	}
	/**
	 * 根据id查询培训信息
	 * @param id
	 * @return Train
	 */
	@Override
	public Train findTrainObjectById(Integer id) {
		Train train = dao.findTrainObjectById(id);
		if(train==null)
			throw new RuntimeException("查不到这条培训数据");
		return train;
	}
	/**
	 * 根据id删除培训信息
	 * @param id
	 * @return int 删除的行数
	 */
	@Override
	public int deleteTrainObjectById(Integer id) {
		if(id==null||id==0)
			throw new RuntimeException("请选择正确的信息id");
		int rows = dao.deleteTrainObjectById(id);
		if(rows==0)
			throw new RuntimeException("删除失败");
		return rows;
	}
}
