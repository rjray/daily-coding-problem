#!/usr/bin/perl

# Page 24, problem 1.3.

use strict;
use warnings;

sub max {
    my ($x, $y) = @_;

    return $x > $y ? $x : $y;
}

sub min {
    my ($x, $y) = @_;

    return $x < $y ? $x : $y;
}

sub subarray_sum {
    my ($fn, @arr) = @_;
    my ($ending_here, $so_far) = (0, 0);

    for my $x (@arr) {
        $ending_here = $fn->($x, $ending_here + $x);
        $so_far      = $fn->($ending_here, $so_far);
    }

    return $so_far;
}

sub max_circular_subarray {
    my (@arr) = @_;

    my $sum = 0;
    for my $x (@arr) {
        $sum += $x;
    }
    my $wraparound = $sum - subarray_sum(\&min, @arr);

    return max(subarray_sum(\&max, @arr), $wraparound);
}

if (@ARGV) {
    print 'Max subarray sum = ' . subarray_sum(\&max, @ARGV) . "\n";
    print 'Max wraparound sum = ' . max_circular_subarray(@ARGV) . "\n";
} else {
    print "Need numbers\n";
}
