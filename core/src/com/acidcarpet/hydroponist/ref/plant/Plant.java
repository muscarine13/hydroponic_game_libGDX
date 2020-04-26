package com.acidcarpet.hydroponist.ref.plant;

import com.acidcarpet.hydroponist.ref.plant.leave.Leave;
import com.acidcarpet.hydroponist.ref.plant.root.Root;

import java.util.List;

public class Plant {

    GenusType genusType;
    VisumType visumType;

    PreVegetationType preVegetationType;
    PostVegetationType postVegetationType;

    PreBloomType preBloomType;
    PostBloomType postBloomType;




    Stages stage;

    List<Leave> leaves;
    List<Root> roots;
}
