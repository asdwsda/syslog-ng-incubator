
git clone https://github.com/balabit/syslog-ng-incubator /source/syslog-ng-incubator

cd /source/syslog-ng-incubator

autoreconf -i

./configure

make

make install
