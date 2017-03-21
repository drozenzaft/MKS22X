
for x in $(seq 1 10)
do
    echo "Silver" $x
    echo ""
    java Test05 $x
    cat ctravel.$x.out
    echo ""
done
