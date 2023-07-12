<<<<<<<< HEAD:backend/src/main/java/com/team4/ims/DTOs/Inventory/shoeDTO/ShoeOrder.java
package com.team4.ims.DTOs.Inventory.shoeDTO;
========
package com.team4.ims.DTOs.Inventory;
>>>>>>>> cfaba24 (Customer services):backend/src/main/java/com/team4/ims/DTOs/Inventory/ShoeOrder.java

import lombok.Data;

@Data
public class ShoeOrder {

    private String shoeName;
    private String shoeColor;
    private String shoeSize;
    private String shoeBrand;
    int quantity;
}
