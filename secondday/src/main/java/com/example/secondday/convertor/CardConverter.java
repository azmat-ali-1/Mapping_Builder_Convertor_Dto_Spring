package com.example.secondday.convertor;

import com.example.secondday.EntryDTO.CardDTO;
import com.example.secondday.Models.Identycard;

public class CardConverter {
    public static Identycard converter(CardDTO cardDTO){

        return Identycard.builder().name(cardDTO.getName()).build();
    }
}
