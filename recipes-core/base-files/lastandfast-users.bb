SUMMARY = "Lastandfast default user setup"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit useradd allarch

USERADD_PACKAGES = "${PN}"
USERADD_PARAM:${PN} = "-m -s /bin/bash -G sudo inari"

FILES:${PN} = " "

ALLOW_EMPTY:${PN} = "1"

