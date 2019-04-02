package com.huishu.productcomplains.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.huishu.productcomplains.model.Menu;
@Repository 
public interface HearderRepository extends JpaRepository<Menu, Integer>{

	/*@Query(value = "from Menu where is_used=0 order by sort asc")
	List<Menu> getMenu();*/

}
