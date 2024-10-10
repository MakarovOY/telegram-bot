FROM gradle:8.10.0-jdk21

WORKDIR /

COPY / .

RUN ./gradlew installBootDist

CMD ./build/install/telegram-bot-boot/bin/telegram-bot
