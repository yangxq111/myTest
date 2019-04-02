package com.huishu.productcomplains.repository;

import com.huishu.productcomplains.model.ConnectionInfo;
import com.huishu.productcomplains.model.FriendlyLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FooterRepository extends JpaRepository<FriendlyLink, Integer>{

    @Query(value = "from FriendlyLink where used=0 order by sort asc")
    List<FriendlyLink> getLinks();

}
