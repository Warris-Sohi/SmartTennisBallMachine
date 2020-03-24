difference(){
    cube([96,81,49]);
    //HOLLOW the case
    translate([4,4,4]){
        cube([88,73,45]);
        }
        //HDMI and POWER
    translate([4,0,4]){
        cube([88,4,10]);
        //USB and LAN
    } translate([92,4,4]){
        cube([4,73,20]);
        }   
}
//the Lid
difference(){
    translate([-108,-4,0]){
        cube([104,89,8]);
        }
     translate([-104,0,2]){
        cube([96,81,6]);
        }   
     translate([-96,10,0]){
        cube([60,60,2]);
        } 
    }
union(){
translate([50,-55,0]){
        cylinder(60,50,40);
    }
difference(){
    translate([50,-55,60]){
        cube([61,24,46],center=true);
    }
    translate([50,-55,64]){
        cube([57,20,42],center=true);
    }
}
}