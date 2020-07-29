package com.mobeom.local_currency.recommend;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

interface RecommendRepository extends JpaRepository<Recommend,Long>, CustomedRecommendRepository{}
interface CustomedRecommendRepository{}
public class RecommendRepositoryImpl extends QuerydslRepositorySupport implements CustomedRecommendRepository{
    @Autowired
    JPAQueryFactory query;

    RecommendRepositoryImpl(){
        super(Recommend.class);
    }

}
