#!/usr/bin/perl

# Page 20, problem 1.1.

use strict;
use warnings;

# Simple solution using division
sub array_prods_simple {
    my @array = @_;

    my $full = 1;
    for my $i (@array) {
        $full *= $i;
    }

    return (map { $full / $_ } @array);
}

# Solution without division
sub array_prods {
    my @array = @_;
    my $last  = $#array;

    # Compute partials
    my @forward  = ();
    my @backward = ();

    for my $i (0 .. $last) {
        if ($i == 0) {
            $forward[0]      = $array[0];
            $backward[$last] = $array[$last];
        } else {
            $forward[$i] = $array[$i] * $forward[$i - 1];
            $backward[$last - $i] =
                $array[$last - $i] * $backward[$last - $i + 1];
        }
    }

    my @prods = ();
    for my $i (0 .. $last) {
        if ($i == 0) {
            push @prods, $backward[$i + 1];
        } elsif ($i == $last) {
            push @prods, $forward[$i - 1];
        } else {
            push @prods, $forward[$i - 1] * $backward[$i + 1];
        }
    }

    return @prods;
}

if (@ARGV) {
    my @a1 = array_prods_simple(@ARGV);
    my @a2 = array_prods(@ARGV);
    print "\@a1=(@a1)\n";
    print "\@a2=(@a2)\n";
} else {
    my @l = qw(1 2 3 4 5);
    my @a1 = array_prods_simple(@l);
    my @a2 = array_prods(@l);
    print "\@a1=(@a1)\n";
    print "\@a2=(@a2)\n";
}
