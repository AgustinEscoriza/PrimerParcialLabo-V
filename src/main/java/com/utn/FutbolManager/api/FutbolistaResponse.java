package com.utn.FutbolManager.api;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class FutbolistaResponse {

    @SerializedName("player_id")
    private Integer player_id;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastname")
    private String lastname;
    @SerializedName("birthday")
    private Date birthday;
    @SerializedName("age")
    private Integer age;
    @SerializedName("weight")
    private Integer weight;
    @SerializedName("height")
    private Integer height;
    @SerializedName("img")
    private String img;
    @SerializedName("country")
    private String country;
}
