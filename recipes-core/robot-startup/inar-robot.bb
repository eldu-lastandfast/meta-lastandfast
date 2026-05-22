SUMMARY = "INAR robot stack autostart service"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit allarch systemd

SRC_URI = "file://inar-robot.service"

SYSTEMD_SERVICE:${PN} = "inar-robot.service"
SYSTEMD_AUTO_ENABLE = "enable"

do_install() {
    install -d ${D}/usr/lib/systemd/system
    install -m 0644 ${WORKDIR}/inar-robot.service ${D}/usr/lib/systemd/system/
}

FILES:${PN} = "/usr/lib/systemd/system/inar-robot.service"

ALLOW_EMPTY:${PN} = "1"
