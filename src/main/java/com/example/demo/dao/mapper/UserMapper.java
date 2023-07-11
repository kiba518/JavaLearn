package com.example.demo.dao.mapper;




import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.List;


public interface UserMapper extends BaseMapper<User> {

//    List<User> findAll();

//    @Select("select * from k_user")
//    List<User> test();
//
//    @Select("select * from k_user where id=#{value}")
//    List<User> test2(Integer id);
//
//    List<User> test3(Integer id);

//    List<SysAnnouncement> queryMessageList(Page<SysAnnouncement> page,
//    @Param("userId")String userId, @Param("fromUser")String fromUser,
//    @Param("starFlag")String starFlag, @Param("beginDate")Date beginDate,
//    @Param("endDate")Date endDate);
//
////  	<!-- 查询消息记录 -->
//	<select id="queryMessageList" resultMap="SysAnnouncement">
//	   select a.*,
//	   		b.read_flag,
//	   		b.star_flag,
//	   		b.id as send_id
//	   from sys_announcement a
//	   join sys_announcement_send b on b.annt_id = a.id
//	   where a.send_status = '1' and a.del_flag = '0' and b.user_id = #{userId}
//		<if test="fromUser!=null and fromUser!=''">
//			and a.sender = #{fromUser}
//		</if>
//
//		<if test="beginDate!=null">
//			and a.create_time &gt;= #{beginDate}
//		</if>
//		<if test="endDate!=null">
//			and a.create_time &lt;= #{endDate}
//		</if>
//
//		<if test="starFlag!=null and starFlag!=''">
//			and b.star_flag = #{starFlag}
//		</if>
//	   order by b.read_flag ASC,a.create_time DESC
//	</select>
//
}
