SUMMARY = "Intel RealSense SDK for D435"
HOMEPAGE = "https://github.com/realsenseai/librealsense"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a1692f06943fa281fd047a22d7e10800"

DEPENDS = "libusb1 cmake-native"

SRC_URI = "git://github.com/realsenseai/librealsense.git;protocol=https;branch=master;name=librealsense \
           git://github.com/nlohmann/json.git;protocol=https;branch=master;name=json;destsuffix=json \
           file://external_json.cmake"

SRCREV_librealsense = "e196cefa896e312d79c2df400c7623aa1e9c62ac"
SRCREV_json = "9cca280a4d0ccf0c08f47a99aa71d1b0e52f8d03"
SRCREV_FORMAT = "librealsense_json"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = "-DBUILD_EXAMPLES=OFF \
                 -DBUILD_GRAPHICAL_EXAMPLES=OFF \
                 -DBUILD_PYTHON_BINDINGS=OFF \
                 -DBUILD_WITH_CUDA=OFF \
                 -DBUILD_UNIT_TESTS=OFF \
                 -DBUILD_WITH_TM2=OFF \
                 -DFORCE_RSUSB_BACKEND=ON"

FILES:${PN} = "${libdir}/*.so* ${bindir}/*"

do_configure:prepend() {
    cp ${WORKDIR}/external_json.cmake ${S}/CMake/external_json.cmake
    mkdir -p ${B}/third-party/json
    cp -r ${WORKDIR}/json/. ${B}/third-party/json/
}
