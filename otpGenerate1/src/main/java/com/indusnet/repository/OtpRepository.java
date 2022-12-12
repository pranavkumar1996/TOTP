package com.indusnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indusnet.model.OtpModel;
@Repository
public interface OtpRepository extends JpaRepository<OtpModel, Long> {
 OtpModel findByMobile(String mobile);
}
