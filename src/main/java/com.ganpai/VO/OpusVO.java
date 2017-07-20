package com.ganpai.VO;

import com.ganpai.dto.OpusDTO;

public class OpusVO extends OpusDTO {
    /**
     * 作品点赞,推荐,收藏数
     */
    private Long totalLike;
    private Long totalRecommend;
    private Long totalCollection;

    public Long getTotalLike() {
        return totalLike;
    }

    public void setTotalLike(Long totalLike) {
        this.totalLike = totalLike;
    }

    public Long getTotalRecommend() {
        return totalRecommend;
    }

    public void setTotalRecommend(Long totalRecommend) {
        this.totalRecommend = totalRecommend;
    }

    public Long getTotalCollection() {
        return totalCollection;
    }

    public void setTotalCollection(Long totalCollection) {
        this.totalCollection = totalCollection;
    }

}