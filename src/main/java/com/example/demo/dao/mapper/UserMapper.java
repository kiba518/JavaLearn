package com.example.demo.dao.mapper;




import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;


@Repository
public interface UserMapper extends BaseMapper<User> {

    List<User> findAll();

    @Select("select * from k_user")
    List<User> test();

    @Select("select * from k_user where id=#{value}")
    List<User> test2(Integer id);

    List<User> test3(Integer id);


    /**
     * $是不转义符合，#是转义符号
     */
    /**
     * 设置@Param("Id")，让xml中直接使用#{Id}
     */
    List<User> test4(@Param("Id")String userId);
    List<User> test5(@Param("id")int id, @Param("name")String name);

    /**
     * name是字符串 所以要加引号 '${name}'
     */
    List<User> test6(@Param("id")int id, @Param("name")String name);

    /**
     *  '${value}' #{value}
     1. #{value}將傳入的數據都當成一個字符串，會對自動傳入的數據加一個雙引號。
     2. ${value}將傳入的數據直接顯示生成在sql中。
     3. #{value}方式可以很大程度防止sql注入。　
     4.${value}方式沒法防止Sql注入。
     5.${value}方式通常用於傳入數據庫對象，例如傳入表名.
     6.通常能用#{value}的就別用${value}.
     MyBatis排序時使用order by 動態參數時須要注意，用${value}而不是#{value}


     1.当传输参数为单个string或基本数据类型和其包装类
     #{}:可以为任意的名字获取参数值
     ${}:只能以${value}或${_parameter}获取
     */

    List<User> queryPageList(Page<User> page, @Param("userId")String userId);

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

//    <select id="getUserList" parameterType="map" resultType="SysUser">
//            　select t.*
//    from sys_user t
//    WHERE t.status = #{status}
//  <if test=' ids != null and ids.size() > 0 '>
//    and t.id not in
//            <foreach collection="ids" item="item" index="index" open="(" close=")" separator=",">
//            #{item}
//  	  </foreach>
//   </if>
//</select>
// <select id=""
//    parameterType=""
//    resultType="">
//    SELECT
//    a.id AS id
//            FROM
//    表名 a
//    WHERE
//    a.***= #{***,jdbcType=BIGINT}
//    AND a.active = 1
//        <choose>
//            <when test="patientDivision != null and patientDivision != '' and patientDivision == 1">
//    AND a.数据库字段 = #{deptId,jdbcType=BIGINT}
//            </when>
//            <when test="patientDivision != null and patientDivision != '' and patientDivision == 3">
//    AND (a.数据库字段 = #{doctorId,jdbcType=BIGINT} OR a.数据库字段is null)
//            </when>
//        </choose>
//        <if test="encounterStatus != null and encounterStatus != ''">
//    AND a.数据库字段 = #{encounterStatus,jdbcType=TINYINT}
//        </if>
//        <choose>
//            <when test="encounterStatus != null and encounterStatus != '' and encounterStatus ==1">
//                <if test="beginTime != null and beginTime != ''">
//    AND a.数据库字段 >= str_to_date(#{beginTime,jdbcType=VARCHAR},'%Y-%m-%d')
//                </if>
//                <if test="endTime != null and endTime != ''">
//    AND str_to_date(#{endTime,jdbcType=VARCHAR},'%Y-%m-%d') >= a.service_date
//            </if>
//                <if test="queryStr != null and queryStr != ''">
//    and (
//            a.数据库字段 like concat("%", #{queryStr, jdbcType = VARCHAR}, "%") escape '/'
//    or 数据库字段 like concat("%",#{queryStr,jdbcType=VARCHAR},"%") escape '/'
//            )
//                </if>
//            </when>
//            <when test="encounterStatus != null and encounterStatus != '' and encounterStatus ==2">
//                <if test="beginTime != null and beginTime != ''">
//    AND a.数据库字段>= str_to_date(#{beginTime,jdbcType=VARCHAR},'%Y-%m-%d %h:%i:%s')
//                </if>
//                <if test="endTime != null and endTime != ''">
//    AND str_to_date(#{endTime,jdbcType=VARCHAR},'%Y-%m-%d %h:%i:%s') >= a.encounter_date
//            </if>
//                <if test="queryStr != null and queryStr != ''">
//    and (
//            a.数据库字段 like concat("%", #{queryStr, jdbcType = VARCHAR}, "%") escape '/'
//    or 数据库字段 like concat("%",#{queryStr,jdbcType=VARCHAR},"%") escape '/'
//    or  数据库字段 like concat("%",#{queryStr,jdbcType=VARCHAR},"%") escape '/'
//            )
//                </if>
//            </when>
//        </choose>
//    order by
//        <foreach item="value" index="key" collection="sortMap.entrySet()" separator=",">
//    ${key} ${value}
//        </foreach>
//    </select>
}
