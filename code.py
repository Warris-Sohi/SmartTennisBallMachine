import RPi.GPIO as GPIO
import time

servoPIN = 18
GPIO.setmode(GPIO.BCM)
GPIO.setup(servoPIN, GPIO.OUT)

p = GPIO.PWM(servoPIN, 50)
p.start(7)

try:
    while True:
        p.ChangeDutyCycle(5)
        print("It's turning")
        time.sleep(0.5)
        p.ChangeDutyCycle(7)
        print("Still turning")
        time.sleep(0.5)
        p.ChangeDutyCycle(9)
        print("And turning")
        time.sleep(0.5)
        p.ChangeDutyCycle(11)
        print("and turning more")
        time.sleep(0.5)
        p.ChangeDutyCycle(9)
        print("And turning again")
        time.sleep(0.5)
        p.ChangeDutyCycle(7)
        print("Turning More")
        time.sleep(0.5)
        p.ChangeDutyCycle(5)
        print("And back again")
        time.sleep(0.5)
        p.ChangeDutyCycle(3)
        print("Ahh")
        time.sleep(0.5)
except KeyboardInterrupt:
    p.stop()
    GPIO.cleanup()
