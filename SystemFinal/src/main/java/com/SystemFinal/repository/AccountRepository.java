package com.SystemFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.SystemFinal.entity.Account;
@Repository("AccountRepository")
public interface AccountRepository extends CrudRepository<Account, Integer>,JpaRepository<Account, Integer>{
	@Query(value="select balance from acco where id=?1",nativeQuery = true)
	public int getBalanceById(int acc);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update acco set balance=balance+?2 where id=?1",nativeQuery = true)
	public void saveBalanceById(int id,int balance);
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update acco set balance=balance-?2 where id=?1",nativeQuery = true)
	public void withdrawById(int id,int balance);
}
