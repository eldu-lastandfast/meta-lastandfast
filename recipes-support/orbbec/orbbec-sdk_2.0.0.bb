SUMMARY = "Orbbec SDK for Gemini 336L"
HOMEPAGE = "https://github.com/orbbec/OrbbecSDK"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=840f904ef7c63233a3d0c60d5e254f9a"

SRC_URI = "git://github.com/orbbec/OrbbecSDK.git;protocol=https;branch=main"
SRCREV = "e1f1f6190253663a796b3f2871691e7d4ba6e5fb"

S = "${WORKDIR}/git"

do_configure() {
    :
}

do_compile() {
    :
}

do_install() {
    install -d ${D}${libdir}
    install -d ${D}${includedir}/orbbec
    cp -r ${S}/lib/arm64/*.so* ${D}${libdir}/
    cp -r ${S}/include/* ${D}${includedir}/orbbec/
}

FILES:${PN} = "${libdir}/*.so* ${includedir}/*"

INSANE_SKIP:${PN} = "already-stripped ldflags dev-deps file-rdeps dev-elf"
INSANE_SKIP:${PN}-dev = "dev-elf ldflags"

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"

ALLOW_EMPTY:${PN} = "1"
