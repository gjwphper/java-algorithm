package algorithm.distribute;

import java.util.*;

public class Id {
    public static void main(String[] args) {
//        SnowFlake snowFlake = new SnowFlake(1,1);
//        System.out.println(snowFlake.nextId());
//        System.out.println("652959500814389248".length());

//        Set<String> stringSet = new HashSet<>();
        Set<String> stringSet = new TreeSet<>();
        String[] arr = {

                "cdm_ykj_rental_receivable",
                "cdm_ykj_rental_finance_payment",
                "cdm_ykj_rental_contract",
                "cdm_ykj_common_room",
                "cdm_ykj_rental_customfields",
                "cdm_ykj_rental_derated",

                "cdm_ykj_rental_receivable",
                "cdm_ykj_rental_finance_payment",
                "cdm_ykj_rental_contract",
                "cdm_ykj_common_room",
                "cdm_ykj_rental_customfields",
                "cdm_ykj_rental_derated",

                "cdm_ykj_rental_receivable",
                "cdm_ykj_rental_finance_payment",
                "cdm_ykj_rental_contract",
                "cdm_ykj_common_room",
                "cdm_ykj_rental_customfields",

                "cdm_ykj_rental_vacant_room",
                "cdm_ykj_rental_for_rent",
                "cdm_ykj_rental_customfields",
                "cdm_ykj_rental_apportion",
                "cdm_ykj_common_room",
                "cdm_ykj_rental_room_operation",
                "cdm_ykj_rental_for_rent",
                "cdm_ykj_rental_apportion_view",

                "cdm_ykj_asset_project_view",
                "cdm_ykj_asset_room",
                "cdm_ykj_asset_customfields",
                "cdm_ykj_asset_business",
                "cdm_ykj_common_room",
                "cdm_ykj_rental_contract",
                "cdm_ykj_rental_customfields",
                "cdm_ykj_rental_vacant_room",
        };
        for (String t :
                arr) {
            boolean add = stringSet.add(t);
            System.out.println(add);
        }
        System.out.println("------------------------------------------------");
        for (String tt :
                stringSet) {
            System.out.println(tt);
        }





    }
}
