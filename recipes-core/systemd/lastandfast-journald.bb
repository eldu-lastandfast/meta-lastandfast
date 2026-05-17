SUMMARY = "Lastandfast journald configuration"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit allarch

SRC_URI = "file://journald.conf"

do_install() {
    install -d ${D}${sysconfdir}/systemd
    install -m 0644 ${WORKDIR}/journald.conf ${D}${sysconfdir}/systemd/journald.conf
}

FILES:${PN} = "${sysconfdir}/systemd/journald.conf"

ALLOW_EMPTY:${PN} = "1"
