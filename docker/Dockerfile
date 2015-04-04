FROM ubuntu:trusty

MAINTAINER Peter Szabo <asdwsda@gmail.com>

RUN apt-get update
RUN apt-get install -y -f \
    python-software-properties \
    software-properties-common \
    git \
    gcc \
    autoconf \
    automake \
    make \
    libtool \
    flex \
    libbison-dev \
    libcap-dev \
    libdbi-dev \
    libesmtp-dev \
    libevtlog-dev \
    libfl-dev \
    libgeoip-dev \
    libglib2.0-dev \
    python-dev \
    pkg-config \
    libhiredis-dev \
    libivykis-dev \
    libjson-c-dev \
    libltdl-dev \
    libmongo-client-dev \
    libnet1-dev \
    libpcre3-dev \
    libriemann-client-dev \
    libssl-dev \
    manpages-dev \
    zlib1g-dev

RUN apt-get install -y -f \
    liblua5.2-dev \
    libperl-dev \
    librdkafka-dev \
    libtokyocabinet-dev \
    libgrok1 \
    libgrok-dev \
    libzmq3-dev

RUN add-apt-repository -y ppa:webupd8team/java
RUN apt-get update
RUN echo debconf shared/accepted-oracle-license-v1-1 select true | debconf-set-selections
RUN echo debconf shared/accepted-oracle-license-v1-1 seen true | debconf-set-selections
RUN apt-get install -y oracle-java7-installer

RUN mkdir /source

COPY build-syslog-ng.sh /
RUN chmod +x /build-syslog-ng.sh && /build-syslog-ng.sh

COPY build-syslog-ng-incubator.sh /
RUN chmod +x /build-syslog-ng-incubator.sh && /build-syslog-ng-incubator.sh

RUN apt-get clean
