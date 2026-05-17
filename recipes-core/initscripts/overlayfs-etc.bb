SUMMARY = "Lastandfast read-only rootfs with overlayfs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit allarch

RDEPENDS:${PN} = "util-linux"

FILES:${PN} = " \
    ${sysconfdir}/fstab \
"

do_install() {
    install -d ${D}${sysconfdir}

    cat > ${D}${sysconfdir}/fstab << 'EOF'
# Lastandfast fstab
# Root filesystem - read only
/dev/root       /               ext4    ro,noatime,errors=remount-ro    0 1

# Data partition - read write for logs and runtime data
/dev/mmcblk0p2  /data           ext4    rw,noatime                      0 2

# Temporary writable overlay in RAM
tmpfs           /tmp            tmpfs   rw,nosuid,nodev,size=256m       0 0
tmpfs           /run            tmpfs   rw,nosuid,nodev,size=64m        0 0
EOF
}
