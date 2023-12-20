LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9741c346eef56131163e13b9db1241b3"

SRC_URI = "git://github.com/COVESA/vsomeip;protocol=https;branch=master"
PV = "1.0+git${SRCPV}"
SRCREV = "64f8d4e872845f804a60f13e457e4df62cfbab61"

S = "${WORKDIR}/git"

DEPENDS = "boost"
inherit cmake

FILES:${PN} = "/usr/lib/* /usr/include/* /usr/etc/vsomeip/*"
