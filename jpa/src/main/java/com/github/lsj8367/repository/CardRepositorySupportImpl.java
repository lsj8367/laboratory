package com.github.lsj8367.repository;

import static com.github.lsj8367.entity.QCard.card;
import static com.github.lsj8367.entity.QCardViewer.cardViewer;
import com.github.lsj8367.domain.CardVo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CardRepositorySupportImpl implements CardRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<CardVo> getCardSummary() {
        jpaQueryFactory.selectFrom(card)
            .leftJoin(card.viewers, cardViewer).fetchJoin()
            .fetch();
        return null;
    }

}
