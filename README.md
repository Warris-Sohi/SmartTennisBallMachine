# SmartTennisBallMachine
warris-sohi.github.io/SmartTennisBallMachine
## Materials Required
##### 1 - Raspberry Pi 4 Model B Kit
##### 1 - TB6621FNG Dual Motor Driver
##### 2 - Model R360 DC motors
##### 1 - 6V - 9V Power Supply 
##### 2 - 1X20 Female Socket Headers, 1X8 Female Socket Headers
##### 3 - 1X2 Female Socket Headers
##  Quick Links
##### [Firmware Code](https://github.com/Warris-Sohi/SmartTennisBallMachine/blob/master/Firmware/tbfng6621.py) 
##### [Fritzing File](https://github.com/Warris-Sohi/SmartTennisBallMachine/raw/master/Electronics/DualMotorDriver.fzz)
##### [Laser Cut Model](https://github.com/Warris-Sohi/SmartTennisBallMachine/raw/master/Mechanical/enclosure%20new.cdr)
## Build Instructions
### Step 1 Test the acquired materials
##### After setting up your Raspberry Pi 4, use a basic python GPIO code to test the output for all you pins for your pi.
##### Test the motor driver by checking that all 3 grounds are connected to each other, and check the connection between VCC to GND, External Power input to GND and PWMA/PWMB to GND.
##### The DC motors can be tested using a small current and voltage input.
##### Check the voltage out put from the power supply.
### Step 2 Testing the breadboard prototype.
##### Then the Connect the motor driver, the DC motors and external power supply on a bread board according to the circuit below and in the given fritzing file. to test them using the code provided.
![Bread Board Design](https://github.com/Warris-Sohi/SmartTennisBallMachine/raw/master/Electronics/DualMotorDriver_bb_v2.jpg)
### Step 3 Build a PCB prototype
##### Build printed circuit provided in the Fritzing file, example given below.
![PCB Design](https://github.com/Warris-Sohi/SmartTennisBallMachine/raw/master/Electronics/DualMotorDriver_pcb_v2.jpg)
##### Use the 1X20 female socket headers and solder them at the bottom of the PCB for the. To mount the PCB on the Raspberry Pi
##### solder the 1X8 and 1X2 socket headers at the top of the PCB to mount the driver and to connect the motors and external power supply respectively.
##### Then test the connections in the PCB, that they are not broken, or are not connected to wrong pins.
##### Then mount the driver on the PCB and the PCB onto the pi 
### Step 4 Project Enclosure
##### The provided .cdr file consists of a case for the Raspberry Pi and mounted PCB and a holder for the DC motors to hold them at required distance so that a ping pong ball can be fit in them and launched. 
##### After enclosure pieces are laser-cut, some of affixes for the Pi case and the DC motors need to shaved off, so that the we can attach them firmly, without needing glue and remove them after, if needed.
