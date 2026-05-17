SUMMARY = "Lastandfast Plymouth boot splash theme"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit allarch

RDEPENDS:${PN} = "plymouth"

SRC_URI = " \
    file://lastandfast/background.png \
    file://lastandfast/logo.png \
    file://lastandfast/lastandfast.plymouth \
    file://lastandfast/lastandfast.script \
"

S = "${WORKDIR}"

PLYMOUTH_THEME = "lastandfast"
THEME_DIR = "${datadir}/plymouth/themes/${PLYMOUTH_THEME}"

do_install() {
    install -d ${D}${THEME_DIR}
    install -m 0644 ${WORKDIR}/lastandfast/background.png ${D}${THEME_DIR}/
    install -m 0644 ${WORKDIR}/lastandfast/logo.png ${D}${THEME_DIR}/
    install -m 0644 ${WORKDIR}/lastandfast/lastandfast.plymouth ${D}${THEME_DIR}/
    install -m 0644 ${WORKDIR}/lastandfast/lastandfast.script ${D}${THEME_DIR}/
}

pkg_postinst_ontarget:${PN}() {
    plymouth-set-default-theme ${PLYMOUTH_THEME}
}

FILES:${PN} = "${THEME_DIR}"
