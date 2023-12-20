# LICENSE = "CLOSED"
# LIC_FILES_CHKSUM = ""

# SRC_URI = "git://github.com/waleedelfieky/vsomeipclientserver.git;protocol=https;branch=main"

# SRCREV= "3fca33e5bca2a96b2cb6e972b6717ad5c3816c0e"

# RDEPENDS:${PN}="vsomeip"

# S = "${WORKDIR}/git"

# do_install() {
#    install -d ${D}/${datadir}/vsomeip-client-server
#    cp -r * ${D}/${datadir}/vsomeip-client-server/
# }

# FILES:${PN} += "${datadir}/vsomeip-client-server/*"


LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "git://github.com/waleedelfieky/vsomeipclientserver.git;protocol=https;branch=main"
SRCREV = "3fca33e5bca2a96b2cb6e972b6717ad5c3816c0e"

DEPENDS="vsomeip"
RDEPENDS:${PN}="vsomeip"

S = "${WORKDIR}/git"

do_compile() {
    # Assuming the source file is hello_world_client_main.cpp
    ${CXX} ${LDFLAGS} -o hello_world_service hello_world_service_main.cpp -lvsomeip3
    ${CXX} ${LDFLAGS} -o hello_world_client hello_world_client_main.cpp -lvsomeip3
}

do_install() {
    install -d ${D}/${datadir}/vsomeip-client-server/build
    install -m 0755 hello_world_client ${D}/${datadir}/vsomeip-client-server/build
    install -m 0755 hello_world_service ${D}/${datadir}/vsomeip-client-server/build
    cp -r * ${D}/${datadir}/vsomeip-client-server/
}

FILES:${PN} += "${datadir}/vsomeip-client-server/*"