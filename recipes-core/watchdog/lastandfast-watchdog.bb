SUMMARY = "Lastandfast hardware watchdog service"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit allarch systemd

RDEPENDS:${PN} = "watchdog"

SRC_URI = "file://lastandfast-watchdog.service"

SYSTEMD_SERVICE:${PN} = "lastandfast-watchdog.service"
SYSTEMD_AUTO_ENABLE = "enable"

do_install() {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/lastandfast-watchdog.service ${D}${systemd_unitdir}/system/
}

FILES:${PN} = "${systemd_unitdir}/system/lastandfast-watchdog.service"
ALLOW_EMPTY:${PN} = "1"
