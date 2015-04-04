SYSLOG_NG_SRC="http://www.balabit.com/downloads/files/syslog-ng/open-source-edition/3.6.2/source/syslog-ng_3.6.2.tar.gz"

cd /source

wget -O - ${SYSLOG_NG_SRC} | tar xzf -

cd /source/syslog-ng-3.6.2

./configure \
 --with-ivykis=internal \
 --with-libmongo-client=internal \
 --enable-all-modules \
 --disable-sun-streams \
 --enable-shared \
 --enable-dynamic-linking \
 --with-python=2.7 && \

make

make install

ldconfig
