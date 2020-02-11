import RPi.GPIO as GPIO
import time

while(1):
    GPIO.setmode(GPIO.BOARD)
    GPIO.setup(7,GPIO.OUT)

    GPIO.output(7,GPIO.HIGH)
    print("Solenoid is turned ON")
    time.sleep(2)
    
    GPIO.output(7,GPIO.LOW)
    print("Solenoid is turned OFF")
    time.sleep(2)
    
    GPIO.cleanup()
