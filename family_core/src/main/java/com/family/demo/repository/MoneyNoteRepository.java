package com.family.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.family.demo.domain.MoneyNote;

@Repository
public interface MoneyNoteRepository extends JpaRepository<MoneyNote,Long> {
	
	@Query("select m from MoneyNote m where accountid = :accountid")
	List<MoneyNote> findbyAccountId(@Param("accountid")Long accountId);
	
	@Query("select m from MoneyNote m where accountid = :accountid AND date between :startDate AND :endDate")
	List<MoneyNote> findbyAccountIdAndDates(@Param("accountid")Long accountId,@Param("startDate")Date startDate,@Param("endDate")Date endDate);

}
