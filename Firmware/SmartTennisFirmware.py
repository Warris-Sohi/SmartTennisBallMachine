##
 # Maker's Digest
 # DC Motor Control with tb6612fng dual h-bridge motor controller
##
from time import sleep      # Import sleep from time
from datetime import datetime
import RPi.GPIO as GPIO     # Import Standard GPIO Module

GPIO.setmode(GPIO.BOARD)      # Set GPIO mode to BCM
GPIO.setwarnings(False);

# PWM Frequency
DCpwmFreq = 100
sepwmFreq =  
# Setup Pins for motor controller
GPIO.setup(7, GPIO.OUT)     # Solenoidcntrl
GPIO.setup(12, GPIO.OUT)    # ServoPWM
GPIO.setup(36, GPIO.OUT)    # AIN2
GPIO.setup(32, GPIO.OUT)    # AIN1
GPIO.setup(37, GPIO.OUT)        # STBY
GPIO.setup(31, GPIO.OUT)        # BIN1
GPIO.setup(33, GPIO.OUT)        # BIN2
GPIO.setup(40, GPIO.OUT)        # PWMA
GPIO.setup(38, GPIO.OUT)        # PWMB

pwmstp = GPIO.PWM(12, sepwmFreq)    # pin 12 to PWM  
pwmb = GPIO.PWM(38, DCpwmFreq)    # pin 38 to PWM
pwma = GPIO.PWM(40, DCpwmFreq)    # pin 40 to PWM
pwma.start(40)
pwmb.start(40)
pwmstp.start(7)


## Functions
###############################################################################
def turnAngle():
    pwmstp.ChangeDutyCycle(3)
    sleep(2)
    pwmstp.ChangeDutyCycle(4)
    sleep(2)
    pwmstp.ChangeDutyCycle(5)
    sleep(2)
    pwmstp.ChangeDutyCycle(6)
    sleep(2)
    pwmstp.ChangeDutyCycle()

def shoot(spd):
    runMotor(0, spd, 1)
    runMotor(1, spd, 0)

def topshot(spd1,spd2):
    runMotor(0, spd1, 1)
    runMotor(1, spd2, 0)

def backshot(spd1,spd2):
    runMotor(0, spd1, 1)
    runMotor(1, spd2, 0)

def runMotor(motor, spd, direction):
    GPIO.output(37, GPIO.HIGH);
    in1 = GPIO.HIGH
    in2 = GPIO.LOW

    if(direction == 1):
        in1 = GPIO.LOW
        in2 = GPIO.HIGH

    if(motor == 0):
        GPIO.output(32, in1)
        GPIO.output(36, in2)
        pwma.ChangeDutyCycle(spd)
    elif(motor == 1):
        GPIO.output(31, in1)
        GPIO.output(33, in2)
        pwmb.ChangeDutyCycle(spd)


def interval():
    GPIO.output(7,GPIO.HIGH)
    sleep(1)
    GPIO.output(7,GPIO.LOW)

def motorStop():
    GPIO.output(37, GPIO.LOW)

## Main
##############################################################################
def main(args=None):
    try:
        while True:
            interval()
            shoot(50)     # run motor forward
            sleep(1)        # ... for 2 seconds
            motorStop()     # ... stop motor
            turnAngle()
            interval()      # delay between motor runs

            topshot(50,30)    # turn Left
            sleep(1)        # ... for 2 seconds
            motorStop()     # ... stop motors
            turnAngle()
            interval()      # delay between motor runs

            backshot(30,50)   # turn Right
            sleep(1)        # ... for 2 seconds
            motorStop()     # ... stop motors
            turnAngle()
            sleep(2)        # delay between motor runs
    except KeyboardInterrupt:
        pass
        motorStop()
        GPIO.cleanup()
if __name__ == "__main__":
    main()
