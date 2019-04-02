package com.huishu.productcomplains.repository;

import com.huishu.productcomplains.model.ConnectionInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectionInfoRepository extends JpaRepository<ConnectionInfo, Integer>{

    @Query(value = "from ConnectionInfo where used=0 order by sort asc")
    List<ConnectionInfo> getConnectionInfo();
}
