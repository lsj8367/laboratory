package com.github.lsj8367.domain;

import com.github.lsj8367.entity.CardViewer;
import java.util.List;

public record CardVo(Long id, String cardName, String alias, List<CardViewer> cardViewers) {

}
