package com.df.Onboarding.Repo;

import com.df.Onboarding.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoManager extends JpaRepository<Users,Integer> {
}
