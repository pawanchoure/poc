package com.pawan.choure.mapper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u0007"}, d2 = {"Lcom/pawan/choure/mapper/TradeMapper;", "", "findByTradeId", "", "Lcom/pawan/choure/model/Trade;", "trade_id", "", "Kotlin-Gradle-SpringBoot-Integration"})
public abstract interface TradeMapper {
    
    @org.jetbrains.annotations.NotNull
    @org.apache.ibatis.annotations.Select(value = {"SELECT * FROM Trade WHERE trade_id = #{trade_id}"})
    public abstract java.util.List<com.pawan.choure.model.Trade> findByTradeId(@org.jetbrains.annotations.NotNull
    @org.apache.ibatis.annotations.Param(value = "trade_id")
    java.lang.String trade_id);
}